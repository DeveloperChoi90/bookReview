package edu.bookreview.dto;

import edu.bookreview.entity.BookReview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class ReviewEditRequestDto {

    private final String title;

    @NotBlank(message = "Please input the url information of the book you want to change.")
    private final String bookBuyUrl;

    @NotBlank(message = "Please write your content to wish edit to your content before.")
    private final String content;

    private final Integer rank;

    public BookReview toEntity(BookReview bookReview){
        return BookReview.builder()
                .user(bookReview.getUser())
                .bookBuyUrl(this.bookBuyUrl)
                .title(this.title)
                .content(this.content)
                .bookImageUrl(bookReview.getBookImageUrl())
                .likeCount(bookReview.getLikeCount())
                .rank(this.rank)
                .build();
    }
}
