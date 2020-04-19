package com.bulut.validation.model;

import com.bulut.validation.marker.OnCreate;
import com.bulut.validation.marker.OnUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SampleDTO implements Serializable {

    @NotNull(groups = OnUpdate.class)
    @Positive(groups = OnUpdate.class)
    @Null(groups = OnCreate.class)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Size(min = 1, max = 2000)
    private String address;
    @Range(min = 0, max = 90)
    @Positive
    private Long age;

}
