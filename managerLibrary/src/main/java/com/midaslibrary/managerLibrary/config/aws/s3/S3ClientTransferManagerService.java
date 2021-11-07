package com.midaslibrary.managerLibrary.config.aws.s3;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.midaslibrary.managerLibrary.config.aws.AmazonS3Configuration;
import com.midaslibrary.managerLibrary.exception.S3Exception;
import com.midaslibrary.managerLibrary.service.BookService;
import com.midaslibrary.managerLibrary.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

@Log4j2
@Service
public class S3ClientTransferManagerService {

    @Value("${aws.s3.pastaUser}")
    private String folderUser;

    @Value("${aws.s3.pastaBook}")
    private String folderBook;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    private static final String MSG_ERROR_UPLOAD = "Failure in upload picture: %";
    private final UserService userService;
    private final BookService bookService;

    private final AmazonS3Configuration s3Configuration;

    @Autowired
    public S3ClientTransferManagerService(UserService userService,
                                          BookService bookService,
                                          AmazonS3Configuration s3Configuration) {
        this.userService = userService;
        this.bookService = bookService;
        this.s3Configuration = s3Configuration;
    }


    public URI uploadPictureUser(Integer userId, MultipartFile multipartFile) {
        URI uri;
        try {
            String userName = userService.getUserFirstName(userId);
            String archiveName = this.folderUser + userId + "/" + userName;//multipartFile.getOriginalFilename();
            InputStream input = multipartFile.getInputStream();
            String archiveType = multipartFile.getContentType();
            uri = uploadPicture(archiveName, input, archiveType);
            userService.setImageKey(archiveName, userId);
            return uri;

        } catch (Exception e) {
            log.error("Failure in save picture of user");
            throw new S3Exception(String.format(MSG_ERROR_UPLOAD, e));
        }
    }

    public URI uploadPictureBookCover(Integer bookId, MultipartFile multipartFile) {
        URI uri;
        try {
            String bookTitle = bookService.getBookTitle(bookId);
            String archiveName = this.folderBook + bookId + "/" + bookTitle;
            InputStream input = multipartFile.getInputStream();
            String archiveType = multipartFile.getContentType();
            uri = uploadPicture(archiveName, input, archiveType);
            bookService.setImageKey(archiveName, bookId);
            return uri;

        } catch (Exception e) {
            log.error("Failure in save picture of book cover");
            throw new S3Exception(String.format(MSG_ERROR_UPLOAD, e));
        }
    }


    public URI uploadPicture(String archiveName, InputStream input, String archiveType) {

        try {
            log.info("Uploading file in S3.");
            ObjectMetadata meta = new ObjectMetadata();
            byte[] bytes = IOUtils.toByteArray(input);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            meta.setContentType(archiveType);
            meta.setContentLength(bytes.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(this.bucketName, archiveName, byteArrayInputStream, meta);
            s3Configuration.amazonS3Client().putObject(putObjectRequest);
            log.info("Uploading complete.");
            return s3Configuration.amazonS3Client().getUrl(this.bucketName, archiveName).toURI();

        } catch (Exception e) {
            log.error(String.format(MSG_ERROR_UPLOAD, e));
            throw new S3Exception(String.format(MSG_ERROR_UPLOAD, e));
        }
    }

}
