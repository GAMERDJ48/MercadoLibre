package com.mercado_libre.mercado_libre.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.mercadolibre.mercadolibre", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest{
    //Probando Github
    @ArchTest
    public static final ArchRule layerRule = layeredArchitecture()
            .layer("Controller").definedBy("com.mercadolibre.mercadolibre.controllers")
            .layer("Service").definedBy("com.mercadolibre.mercadolibre.services")
            .layer("Persistence").definedBy("com.mercadolibre.mercadolibre.repositories")
            .layer("Exception").definedBy("com.mercadolibre.mercadolibre.exceptions")
            .layer("Logic").definedBy("com.mercadolibre.mercadolibre.logic")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service")
            .whereLayer("Exception").mayOnlyBeAccessedByLayers("Logic")
            .whereLayer("Logic").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    public static final ArchRule controllersNameRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("com.mercadolibre.mercadolibre.controllers");

    @ArchTest
    public static final ArchRule controllersAnnotation =
            classes().that().resideInAPackage("com.mercadolibre.mercadolibre.controllers").should().beAnnotatedWith(RestController.class).orShould().beInterfaces();

    @ArchTest
    public static final ArchRule servicesNameRule =
            classes().that().haveSimpleNameEndingWith("Service").should().resideInAPackage("com.mercadolibre.mercadolibre.services");

    @ArchTest
    public static final ArchRule servicesAnnotation =
            classes().that().resideInAPackage("com.mercadolibre.mercadolibre.services").should().beAnnotatedWith(Service.class).orShould().beInterfaces();

    @ArchTest
    public static final ArchRule entitiesAnnotation =
            classes().that().resideInAPackage("com.mercadolibre.mercadolibre.entities").should().beAnnotatedWith(Entity.class).andShould().beAnnotatedWith(Audited.class);

    @ArchTest
    public static final ArchRule repositoriesNameRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("com.mercadolibre.mercadolibre.repositories");

    @ArchTest
    public static final ArchRule exceptionsNameRule =
            classes().that().haveSimpleNameEndingWith("Exception").should().resideInAPackage("com.mercadolibre.mercadolibre.exceptions");



}
