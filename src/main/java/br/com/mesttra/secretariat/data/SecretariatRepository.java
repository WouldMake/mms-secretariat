package br.com.mesttra.secretariat.data;

import br.com.mesttra.secretariat.model.Secretariat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretariatRepository extends JpaRepository<Secretariat, Long> {
}
