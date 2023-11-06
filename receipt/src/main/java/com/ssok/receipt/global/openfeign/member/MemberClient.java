package com.ssok.receipt.global.openfeign.member;

import com.ssok.receipt.global.api.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "member-service", url = "https://member.ssok.site/api/member-service")
public interface MemberClient {

    @GetMapping(value = "/member/seq")
    ApiResponse<Long> getMemberSeq(@RequestParam("member-uuid") String memberUUID);

    @GetMapping(value = "/member/ci")
    ApiResponse<String> getMemberCi(@RequestParam("member-seq") Long memberSeq);

    @GetMapping(value = "/member/name")
    ApiResponse<String> getMemberName(@RequestParam("member-seq") Long memberSeq);

}