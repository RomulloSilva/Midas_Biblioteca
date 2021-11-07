package com.midaslibrary.managerLibrary.controller;


public class UserDtoControllerTest {

    /*
    private final UsersEntity usersEntityMock = UsersEntityMock.getUserMock();
    private final Integer userId = 1;

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void setClose() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("User search test by id, search success")
    public void getUserById_Sucess() {

        doReturn(usersEntityMock).when(userService).getUserById(Mockito.anyInt());
        userController = new UserController(userService, s3ClientTransferManagerService);
        assertThat(userController.getUserById(userId).equals(ResponseEntity.ok()));

    }

    @Test
    @DisplayName("User search test by id, null result")
    public void getUserById_Null() {

        doReturn(null).when(userService).getUserById(Mockito.anyInt());
        userController = new UserController(userService, s3ClientTransferManagerService);
        assertThat(userController.getUserById(userId).equals(ResponseEntity.noContent()));

    }
     */


}
