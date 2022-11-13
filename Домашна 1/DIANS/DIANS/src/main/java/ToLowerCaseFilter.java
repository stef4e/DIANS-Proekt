public class ToLowerCaseFilter implements Filter<String>{

    @Override
    public String execute(String input) {
        if (input != null) {
            return input.toLowerCase();
        }
        return null;
    }
}
