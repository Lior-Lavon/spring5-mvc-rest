package guru.springframework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private Long id;
    private String name;
    private String vendor_url;
}
