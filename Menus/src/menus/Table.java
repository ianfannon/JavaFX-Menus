package menus;

/**
 * Created by Ian James Fannon on 1/7/2017.
 */
public class Table {

    private String fileName;
    private double fileSize;
    private String format;

    public Table() {
        fileName = "";
        fileSize = 0.0;
        format = "";
    }

    public Table(String fileName, double fileSize, String format) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.format = format;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
