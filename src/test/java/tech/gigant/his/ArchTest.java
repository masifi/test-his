package tech.gigant.his;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tech.gigant.his");

        noClasses()
            .that()
            .resideInAnyPackage("tech.gigant.his.service..")
            .or()
            .resideInAnyPackage("tech.gigant.his.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..tech.gigant.his.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
