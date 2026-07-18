# Difference Between JPA, Hibernate and Spring Data JPA

## Overview

In Java enterprise applications, JPA, Hibernate, and Spring Data JPA are commonly used for database operations. Although they are related, they serve different purposes.

---

## 1. JPA (Java Persistence API)

### Definition
JPA is a specification provided by Java for Object Relational Mapping (ORM).

### Purpose
It defines a standard set of interfaces and annotations for mapping Java objects to database tables.

### Examples

Annotations provided by JPA:

```java
@Entity
@Table
@Id
@Column
@OneToMany
@ManyToOne
```

### Key Points

- JPA is only a specification.
- It does not contain any implementation.
- An implementation is required to use JPA.

---

## 2. Hibernate

### Definition

Hibernate is an ORM framework and one of the most popular implementations of JPA.

### Purpose

Hibernate converts Java objects into database records and vice versa.

### Example

```java
@Entity
public class Country {
    @Id
    private String code;
}
```

Hibernate converts operations such as:

```java
countryRepository.findAll();
```

into SQL queries:

```sql
SELECT * FROM country;
```

### Key Points

- Hibernate implements JPA.
- Generates SQL automatically.
- Handles object-to-table mapping.
- Provides additional features beyond JPA.

---

## 3. Spring Data JPA

### Definition

Spring Data JPA is a framework built on top of JPA and Hibernate.

### Purpose

It reduces boilerplate code by automatically generating repository implementations.

### Example

Without Spring Data JPA:

```java
EntityManager em;
em.persist(country);
```

With Spring Data JPA:

```java
countryRepository.save(country);
```

Repository:

```java
public interface CountryRepository
        extends JpaRepository<Country, String> {
}
```

Spring automatically provides implementations for:

- save()
- findAll()
- findById()
- delete()
- count()

### Key Points

- Built on top of JPA.
- Uses Hibernate internally.
- Eliminates manual DAO implementation.
- Simplifies database operations.

---

## Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
|----------|-----|------------|----------------|
| Type | Specification | Framework | Framework |
| Provides Implementation | No | Yes | No |
| ORM Support | Defines ORM Rules | Implements ORM | Uses JPA/Hibernate |
| SQL Generation | No | Yes | Through Hibernate |
| Repository Support | No | Limited | Yes |
| Boilerplate Reduction | No | Partial | High |

---

## Architecture

Application
↓
Spring Data JPA
↓
JPA
↓
Hibernate
↓
MySQL Database

---

## Conclusion

- JPA defines the standard for ORM.
- Hibernate implements the JPA specification and performs ORM operations.
- Spring Data JPA simplifies database access by providing repository abstractions on top of JPA and Hibernate.

Together, they enable efficient and maintainable database interaction in Spring applications.