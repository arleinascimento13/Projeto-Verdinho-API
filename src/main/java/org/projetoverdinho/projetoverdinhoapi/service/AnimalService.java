package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.dto.AnimalDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AnimalModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaAnimalModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.projetoverdinho.projetoverdinhoapi.repository.AnimalRepository;
import org.projetoverdinho.projetoverdinhoapi.repository.PessoaAnimalRepository;
import org.projetoverdinho.projetoverdinhoapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AnimalService implements IService<AnimalModel> {

    @Autowired
    private AnimalRepository repo;

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private PessoaAnimalRepository pessoaAnimalRepository;

    @Override
    public AnimalModel add(AnimalModel animalModel) {
        return null;
    }

    @Override
    public AnimalModel remove(Long id) {
        return null;
    }

    @Override
    public AnimalModel update(Long id, Map<String, String> updates) {
        return null;
    }

    @Override
    public List<AnimalModel> listAll() {
        return List.of();
    }

    @Override
    public AnimalModel getById(Long id) {
        return null;
    }

    public AnimalModel adicionarAnimalComDono(String pessoaCPF, AnimalModel animal) {
        AnimalModel animalSalvo = repo.save(animal);
        PessoaModel pessoa = pesssoaRepository.findByCpf(pessoaCPF).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        PessoaAnimalModel relacao = new PessoaAnimalModel();
        relacao.setPessoa(pessoa);
        relacao.setAnimalId(animalSalvo.getId());
        relacao.setDonoAtual(true);
        relacao.setDataAquisicao(LocalDate.now());

        pessoaAnimalRepository.save(relacao);

        return animalSalvo;
    }

    public AnimalDTO listarAnimalCompleto(Long id) {
        AnimalModel animalModel = repo.findById(Math.toIntExact(id)).orElse(null);

        if (animalModel == null) {
            return null;
        }

        List<PessoaAnimalModel> relacoes = pessoaAnimalRepository.findByAnimalId(animalModel.getId());

        PessoaModel atualDono = null;
        List<PessoaModel> antigosDonos = new ArrayList<>();

        for (PessoaAnimalModel relacao : relacoes) {
            PessoaModel pessoa = relacao.getPessoa(); // requer relacionamento JPA no PessoaAnimalModel
            if (relacao.getDonoAtual()) {
                atualDono = pessoa;
            } else {
                antigosDonos.add(pessoa);
            }
        }

        List<String> imagens = List.of(animalModel.getImgUrl()); // adaptar caso tenha várias

        return new AnimalDTO(
                animalModel.getId(),
                antigosDonos,
                atualDono,
                animalModel.getRaca(),
                animalModel.getDescricao(),
                imagens
        );
    }
}
