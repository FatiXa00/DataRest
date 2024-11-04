package ma.emsi.tp_datarestg61;

import ma.emsi.tp_datarestg61.enums.Genre;
import ma.emsi.tp_datarestg61.model.Centre;
import ma.emsi.tp_datarestg61.model.Etudiant;
import ma.emsi.tp_datarestg61.repository.CentreRepository;
import ma.emsi.tp_datarestg61.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpDataRestG61Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TpDataRestG61Application.class, args);
    }
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    CentreRepository centreRepository;
    @Override
    public void run(String... args) throws Exception {
        Centre centre1 = Centre.builder()
                .nom("Centre Casablanca")
                .adresse("123 Rue de Casablanca")
                .build();
        centreRepository.save(centre1);

        Centre centre2 = Centre.builder()
                .nom("Centre Rabat")
                .adresse("456 Avenue de Rabat")
                .build();
        centreRepository.save(centre2);

        Etudiant et1 = Etudiant.builder()
                .nom("Adnani")
                .prenom("Morad")
                .genre(Genre.Homme)
                .centre(centre1)
                .build();
        etudiantRepository.save(et1);
        Etudiant et2 = Etudiant.builder()
                .nom("Sahraoui")
                .prenom("Fatima Zahraa")
                .genre(Genre.Femme)
                .centre(centre1)
                .build();
        etudiantRepository.save(et2);

        Etudiant et3 = Etudiant.builder()
                .nom("Bouanan")
                .prenom("Aymen")
                .genre(Genre.Homme)
                .centre(centre2)
                .build();

        etudiantRepository.save(et3);
    }
}
