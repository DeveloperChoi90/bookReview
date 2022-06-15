package edu.bookreview.dto;

import edu.bookreview.entity.BookReview;
import edu.bookreview.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public class ReviewsRequestDto {

    @NotBlank(message = "Please input the rank of this post")
    private final Integer rank;

    @NotBlank(message = "You must write the title of this Posting.")
    private final String title;

    @NotBlank(message = "You must need to the url information of this book")
    private final String bookBuyUrl;
    // spring 에서 사용하는 파일 타입

    @NotNull(message = "Please select upload file.")
    private final MultipartFile file;

    @NotBlank(message = "Please write your content.")
    private final String content;

    @Builder
    public ReviewsRequestDto(Integer rank, String title, String bookBuyUrl, MultipartFile file, String content){

        this.rank = rank;
        this.title = title;
        this.bookBuyUrl = bookBuyUrl;
        this.file = file;
        this.content = content;
    }

    public BookReview toEntity(User user){
        return BookReview.builder()
                .user(user)
                .title(this.title)
                .bookBuyUrl(this.bookBuyUrl)
                .content(this.content)
                .rank(this.rank)
                .build();
    }
}

