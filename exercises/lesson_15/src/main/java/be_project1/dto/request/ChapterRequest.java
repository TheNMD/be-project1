package be_project1.lesson_15.dto.request;

public class ChapterRequest {
    private String chapterName;

    public ChapterRequest() {}

    public ChapterRequest(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}
