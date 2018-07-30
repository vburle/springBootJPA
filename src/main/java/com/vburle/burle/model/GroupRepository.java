/*
 * Copyright (c) 2018. Venkata SN Burle Code.
 */

package com.vburle.burle.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
