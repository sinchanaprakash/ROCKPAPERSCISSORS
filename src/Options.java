public enum Options {
    ROCK(1, 2), PAPER(2, 3), SCISSOR(3, 1), EMPTY(-1, -1);

    private int choice;
    private int winWhen;

    Options(int choice, int winWhen) {

        this.choice = choice;
        this.winWhen = winWhen;
    }

    public static Options valueOf(int userEnteredOption) {
        for (Options option : Options.values()) {
            if (userEnteredOption == option.choice) {
                return option;
            }
        }
        return EMPTY;
    }

    public boolean isWinBy(Options option) {
        return this.winWhen == option.choice;
    }
}
enum Player {
    USER, MACHINE, TIE;
}