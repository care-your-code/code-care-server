package site.codecare.domain.community.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.codecare.global.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Entity
public class Post extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "Integer default 0", nullable = false)
    private int view;

    private String email;

    @Builder
    public Post(String title, String content, int view, String email) {
        this.title = title;
        this.content = content;
        this.view = view;
        this.email = email;
    }

}
