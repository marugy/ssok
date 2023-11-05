package com.ssok.member.domain.entity;

import com.ssok.member.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DynamicInsert
@ToString
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    @Column(name="member_uuid",nullable = false)
    private String memberUuid;

    @Column(name="member_name",nullable = false)
    private String memberName;

    @Column(name="member_id",nullable = false)
    private String memberId;

    @Column(name="member_password",nullable = false)
    private String memberPassword;

    @Column(name="member_phone",nullable = false)
    private String memberPhone;

    @Column(name="member_ci")
    private String memberCi;

    @Column(name="member_ci_create_date")
    private LocalDateTime memberCiCreateDate;

    @Column(name="member_mydata_access_token")
    private String memberMydataAccessToken;

    @Column(name="member_account_num")
    private String memberAccountNum;

    @Column(name="member_is_saving",nullable = false)
    private boolean memberIsSaving;

    @Column(name="member_is_verification",nullable = false)
    private boolean memberIsVerification;

    @Column(name="member_is_deleted",nullable = false)
    private boolean memberIsDeleted;

    @Column(name="member_refresh_token")
    private String memberRefreshToken;

    public void updateRefreshToken(String refreshToken){
        this.memberRefreshToken = refreshToken;
    }
}
