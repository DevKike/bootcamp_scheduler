package com.bootcamp.scheduler.testdata;

import com.bootcamp.scheduler.domain.model.Technology;

public class TestData {

    public static final long TECHNOLOGY_ID = 1L;
    public static final String TECHNOLOGY_NAME = "MySQL";
    public static final String TECHNOLOGY_DESCRIPTION = "Relational database manager";

    public static Technology getValidTechnologyData() {
        return new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION);
    }

    public static void getTechnologyDataWithEmptyName() {
        new Technology(TECHNOLOGY_ID, "", TECHNOLOGY_DESCRIPTION);
    }

    public static void getTechnologyDataWithEmptyDescription() {
        new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, "");
    }

    public static void getTechnologyDataWithNameExceedsAllowedSize() {
        new Technology(TECHNOLOGY_ID, "Lorem ipsum dolor sit amet consectetur adipiscing elit montes sed nulla, velit curabitur " +
                "elementum eu leo augue porta libero in, id cursus posuere eleifend mus maecenas lacus semper magnis. " +
                "Ut lectus hendrerit viverra scelerisque fermentum at bibendum, sollicitudin justo et eros luctus nisl vivamus, " +
                "lacinia duis gravida proin aliquam natoque.", TECHNOLOGY_DESCRIPTION);
    }

    public static void getTechnologyDataWithDescriptionExceedsAllowedSize() {
        new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, "Lorem ipsum dolor sit amet consectetur adipiscing elit lectus felis, " +
                "aptent elementum blandit fusce pulvinar proin nostra viverra mollis, magna torquent natoque sociis posuere habitant nec congue. " +
                "Dignissim condimentum morbi eu malesuada curabitur mus aliquam, cursus rutrum primis nulla platea in, " +
                "praesent luctus tincidunt et turpis tellus. Gravida lobortis non hendrerit egestas phasellus placerat himenaeos bibendum imperdiet," +
                " sapien dui vulputate taciti molestie orci erat fringilla lacus laoreet, nam nunc quam id suscipit per porttitor sodales. " +
                "Urna tempor tortor sollicitudin montes aliquet, tristique nisi dapibus nullam eleifend, sagittis fermentum facilisi convallis.");
    }
}
