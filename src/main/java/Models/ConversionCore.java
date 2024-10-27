package Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Conversion {
    private String fromCode;
    private String toCode;
    private BigDecimal rate;
    private LocalDate lastDate;

    public Conversion(ConversionDTO dto) {
        this.fromCode = dto.base_code();
        this.toCode = dto.target_code();
        this.rate = BigDecimal.valueOf(Long.parseLong(dto.conversion_rate()));
        this.lastDate = LocalDate.parse(dto.time_last_update_utc());
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conversion{");
        sb.append("fromCode= '").append(fromCode).append('\'');
        sb.append(", toCode= '").append(toCode).append('\'');
        sb.append(", rate= ").append(rate);
        sb.append(", lastDate= ").append(lastDate);
        sb.append('}');
        return sb.toString();
    }
}
