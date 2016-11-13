package mbc.sdos.es.mbc.domain.model;

import java.util.Date;

/**
 * Created by jose.fernandez on 29/10/2016.
 */

public class ReviewDomain extends BaseDomain {

    private BookDomain book;
    private ReviewerDomain reviewer;
    private SourceDomain source;
    private String Title;
    private String Body;
    private Date date;


    public BookDomain getBook() {
        return book;
    }

    public void setBook(BookDomain book) {
        this.book = book;
    }

    public ReviewerDomain getReviewer() {
        return reviewer;
    }

    public void setReviewer(ReviewerDomain reviewer) {
        this.reviewer = reviewer;
    }

    public SourceDomain getSource() {
        return source;
    }

    public void setSource(SourceDomain source) {
        this.source = source;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
