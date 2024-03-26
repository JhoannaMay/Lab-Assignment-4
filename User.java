class User {
    private String username;
    private final String password;
    private int loginAttempts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loginAttempts = 1;
    }

    public void login(String passwordAttempt) throws InvalidPasswordException, MaxLoginAttemptsExceededException {
        if (!passwordAttempt.equals(password)) {
            throw new InvalidPasswordException();
        } else {
            System.out.println("Login successful <3");
        }
    }

    public void attemptLogin(String passwordAttempt) throws InvalidPasswordException, MaxLoginAttemptsExceededException {
        if (loginAttempts >= 3) {
            throw new MaxLoginAttemptsExceededException();
        } else {
            loginAttempts++;
            login(passwordAttempt);
        }
    }
}