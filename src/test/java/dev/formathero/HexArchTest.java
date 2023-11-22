package dev.formathero;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@Tag("architecture")
@AnalyzeClasses(packages = "dev.formathero.datetimeformatter")
class HexArchTest {

    @Test
    void applicationMustNotBeAccessedByDomain() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("dev.formathero.datetimeformatter");

        var rule = layeredArchitecture().consideringAllDependencies()
                .layer("Adapter").definedBy("..adapter..")
                .layer("Application").definedBy("..application..")
                .layer("Domain").definedBy("..domain..")
                .layer("Startup").definedBy("dev.formathero.datetimeformatter")

                .whereLayer("Adapter").mayOnlyBeAccessedByLayers("Startup")
                .whereLayer("Application").mayOnlyBeAccessedByLayers("Adapter", "Startup")
                .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Adapter", "Startup");

        rule.check(importedClasses);
    }
}