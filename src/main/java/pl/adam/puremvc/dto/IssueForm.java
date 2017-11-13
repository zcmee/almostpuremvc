package pl.adam.puremvc.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SkyNET on 2017-11-13.
 */
public class IssueForm {
    @Size(min = 3, max = 20, message = "Tytuł jest polem obowiązkowym")
    private String title;
    @Size(max = 200)
    private String content;
    @NotNull(message = "Wartość priorytetu nie może być pusta")
    @Min(3)
    private Integer priority;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "IssueForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", priority=" + priority +
                '}';
    }
}
