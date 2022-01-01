package analyzer;

public class FilePattern {
    private int priority;
    private String pattern;
    private String fileType;

    public FilePattern(int priority, String pattern, String fileType) {
        this.priority = priority;
        this.pattern = pattern;
        this.fileType = fileType;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFileType() {
        return fileType;
    }
}
