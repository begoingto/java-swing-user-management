/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package app.data;

import java.util.List;
import lombok.Builder;

/**
 *
 * @author begoingto
 */
@Builder
public record ImportResponces<T>(
        Integer totalSuccess,
        Integer totalFail,
        List<T> data
        ) {
}
