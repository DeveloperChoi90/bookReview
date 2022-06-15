package edu.bookreview.dto;

import edu.bookreview.entity.BookReview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class ReviewEditRequestDto {

    @NotBlank
    private final String title;

    @NotBlank
    private final String bookBuyUrl;

    @NotBlank
    private final String content;

    @NotBlank
    private final Integer ranking;

    public BookReview toEntity(BookReview bookReview){
        return BookReview.builder()
                .user(bookReview.getUser())
                .bookBuyUrl(this.bookBuyUrl)
                .title(this.title)
                .content(this.content)
                .bookImageUrl(bookReview.getBookImageUrl())
                .likeCount(bookReview.getLikeCount())
                .rank(this.ranking)
                .build();
    }
}
