package com.eis_project.auth.api.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * packageName   : com.eis_project.auth.api.dto
 * fileName      : TokenInfoDTO
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Data
@Alias("tokenInfoDTO")
public class TokenInfoDTO {
    private Integer emplNo;
    private LocalDateTime endDate;
}
