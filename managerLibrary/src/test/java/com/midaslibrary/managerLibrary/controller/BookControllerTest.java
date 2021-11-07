package com.midaslibrary.managerLibrary.controller;


public class BookControllerTest {

   /*
    private final BooksEntity booksEntityMock = BooksEntityMock.getBookMock();
    private final Integer bookId = 1;

    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void setClose() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Book search test by id, search success")
    public void getBookById_Sucess() {

        doReturn(booksEntityMock).when(bookService).getBookById(Mockito.anyInt());
        bookController = new BookController(bookService);
        assertThat(bookController.getBookById(bookId).equals(ResponseEntity.ok()));

    }

    @Test
    @DisplayName("Book search test by id, null result")
    public void getBookById_Null() {

        doReturn(null).when(bookService).getBookById(Mockito.anyInt());
        bookController = new BookController(bookService);
        assertThat(bookController.getBookById(bookId).equals(ResponseEntity.noContent()));

    }
    */

}
