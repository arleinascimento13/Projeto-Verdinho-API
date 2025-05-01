package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.dto.AnimalDTO;
import org.projetoverdinho.projetoverdinhoapi.dto.MultaAnimalDTO;
import org.projetoverdinho.projetoverdinhoapi.dto.PessoaDTO;
import org.projetoverdinho.projetoverdinhoapi.entity.AnimalModel;
import org.projetoverdinho.projetoverdinhoapi.entity.MultaAnimalModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaAnimalModel;
import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;
import org.projetoverdinho.projetoverdinhoapi.repository.AnimalRepository;
import org.projetoverdinho.projetoverdinhoapi.repository.MultaAnimalRepository;
import org.projetoverdinho.projetoverdinhoapi.repository.PessoaAnimalRepository;
import org.projetoverdinho.projetoverdinhoapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalService implements IService<PessoaAnimalModel> {

    @Autowired
    private AnimalRepository repo;

    @Autowired
    private PessoaRepository pesssoaRepository;

    @Autowired
    private PessoaAnimalRepository pessoaAnimalRepository;

    @Autowired
    private MultaAnimalRepository multaAnimalRepository;

    @Override
    public PessoaAnimalModel add(PessoaAnimalModel animalModel) {
        return null;
    }

    @Override
    public PessoaAnimalModel remove(Long id) {
        return null;
    }

    @Override
    public PessoaAnimalModel update(Long id, Map<String, String> updates) {
        return null;
    }

    @Override
    public List<PessoaAnimalModel> listAll() {
        return pessoaAnimalRepository.findAll();
    }

    @Override
    public PessoaAnimalModel getById(Long id) {
        return null;
    }

    public AnimalModel adicionarAnimalComDono(String pessoaCPF, AnimalModel animal) {
        PessoaModel pessoa = pesssoaRepository.findByCpf(pessoaCPF).orElseThrow();
        animal.setStatus(StatusAtivo.ATIVO);

        AnimalModel animalSalvo = repo.save(animal);

        PessoaAnimalModel relacao = new PessoaAnimalModel();
        relacao.setPessoa(pessoa);
        relacao.setAnimal(animalSalvo);
        relacao.setDonoAtual(true);
        relacao.setDataAquisicao(LocalDate.now());

        pessoaAnimalRepository.save(relacao);

        return animalSalvo;
    }

    public AnimalDTO listarAnimalCompleto(Long id) {
        AnimalModel animalModel = repo.findById(id).orElseThrow();

        List<PessoaAnimalModel> relacoes = pessoaAnimalRepository.findByAnimalId(animalModel.getId());

        PessoaModel atualDono = null;

        List<PessoaModel> antigosDonos = new ArrayList<>();

        for (PessoaAnimalModel relacao : relacoes) {
            PessoaModel pessoa = relacao.getPessoa();
            if (relacao.getDonoAtual()) {
                atualDono = pessoa;
            } else {
                antigosDonos.add(pessoa);
            }
        }

        PessoaDTO donoAtualDTO = atualDono != null ? new PessoaDTO(
                atualDono.getNome(),
                atualDono.getCpf(),
                atualDono.getTelefone()
        ) : null;

        List<PessoaDTO> antigosDonosDTO = antigosDonos.stream().map(dono -> new PessoaDTO(dono.getNome(), dono.getCpf(), dono.getTelefone()))
                .collect(Collectors.toList());

//        // Buscando as multas
//        List<MultaAnimalModel> multas = multaAnimalRepository.findByAnimalId(animalModel.getId());
//        List<MultaAnimalDTO> multasDTO = multas.stream()
//                .map(multa -> new MultaAnimalDTO(
//                        multa.getId(),
//                        multa.getDescricao(),
//                        multa.getValor(),
//                        multa.getAnimal();
//                        multa.getDataMulta(),
//                        multa.getStatus(),
//                        multa.getMotivoCancelamento(),
//                        multa.getUrlComprovante()
//                ))
//                .collect(Collectors.toList());

        // Criando o DTO final
//        return new AnimalDTO(
//                animalModel.getId(),
//                donoAtualDTO,
//                antigosDonosDTO,
//                animalModel.getRaca(),
//                animalModel.getDescricao(),
//                multasDTO
//        );
        AnimalDTO i = new AnimalDTO();
        return i;
    }


    public List<AnimalModel> buscarAnimaisPorCpfDono(String cpfDono) {
        PessoaModel pessoa = pesssoaRepository.findByCpf(cpfDono).orElseThrow();

        List<PessoaAnimalModel> relacoes = pessoaAnimalRepository.findByPessoaId(pessoa.getId());

        List<AnimalModel> animais = new ArrayList<>();

        for (PessoaAnimalModel relacao : relacoes) {
            animais.add(relacao.getAnimal());
        }

        return animais;
    }
}
