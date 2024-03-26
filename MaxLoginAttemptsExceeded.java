class MaxLoginAttemptsExceededException extends Exception {
    public MaxLoginAttemptsExceededException() {
        super("Maximum login attempts exceeded.");
    }
}