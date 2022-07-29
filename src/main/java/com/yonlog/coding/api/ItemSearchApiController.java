package com.yonlog.coding.api;

import com.yonlog.coding.dto.SearchRequest;
import com.yonlog.coding.dto.SearchResponse;
import com.yonlog.coding.service.ItemSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Search API", description = "검색 관련 API 목록")
@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
@Slf4j
public class ItemSearchApiController {

    private final ItemSearchService itemSearchService;

    @Operation(description = "검색 파라미터를 이용하여 질의한 결과를 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "applic ation/json", schema = @Schema(implementation = SearchResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    })
    @PostMapping(value = "", produces = "application/json; charset=utf8")
    public ResponseEntity<SearchResponse> search(SearchRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            SearchResponse response = new SearchResponse();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                log.info("검증 오류 발생: {}", fieldError.getDefaultMessage());
                response.setMessage(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(itemSearchService.search(request), HttpStatus.OK);
    }

}
