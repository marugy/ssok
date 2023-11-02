package com.ssok.namecard.domain.api;

import static com.ssok.namecard.global.api.ApiResponse.ERROR;
import static com.ssok.namecard.global.api.ApiResponse.OK;

import com.ssok.namecard.domain.api.dto.request.ExchangeSingleRequest;
import com.ssok.namecard.domain.exception.NamecardException;
import com.ssok.namecard.domain.maria.entity.Namecard;
import com.ssok.namecard.domain.mongo.document.TestUser;
import com.ssok.namecard.domain.service.NamecardQueryService;
import com.ssok.namecard.domain.service.NamecardService;
import com.ssok.namecard.domain.service.dto.NamecardCreateRequest;
import com.ssok.namecard.global.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/namecard-service")
public class NamecardController {

    private final NamecardService namecardService;
    private final NamecardQueryService namecardQueryService;

    /**
     * 명함 등록
     * @param namecardCreateRequest
     * @param memberId
     * @return
     */
    @PostMapping("/")
    public ApiResponse<Void> createNamecardRequest(
        @RequestBody NamecardCreateRequest namecardCreateRequest,
        @RequestHeader Long memberId
    ){
        namecardService.createNamecard(namecardCreateRequest, memberId);
        return OK(null);
    }

    /**
     * 1:1 명함 교환
     * @param exchangeSingleRequest
     * @return
     */
    @PostMapping("/exchange/single")
    public ApiResponse<Void> exchangeNamecards(
        @RequestBody ExchangeSingleRequest exchangeSingleRequest
    ){
        namecardService.exchangeSingle(exchangeSingleRequest);
        return OK(null);
    }

    /** 명함 상세 조회 */
    @GetMapping("/{namecardId}")
    public ApiResponse<?> getNamecardDetail(@PathVariable Long namecardId){
        return OK(null);
    }


    /** 명함 목록 조회 */

    /** 명함 지도 조회 */

    /** 명함 타임라인 조회 */

    /** 명함 메모 조회 */
    @GetMapping("/test")
    public ApiResponse<TestUser> getTestUser(@RequestParam String name){
        return OK(namecardQueryService.getUserByName(name));
    }

}