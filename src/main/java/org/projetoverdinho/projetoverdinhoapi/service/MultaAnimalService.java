//package org.projetoverdinho.projetoverdinhoapi.service;
//
//import org.projetoverdinho.projetoverdinhoapi.dto.MultaAnimalDTO;
//import org.projetoverdinho.projetoverdinhoapi.entity.AnimalModel;
//import org.projetoverdinho.projetoverdinhoapi.entity.MultaAnimalModel;
//import org.projetoverdinho.projetoverdinhoapi.entity.PessoaModel;
//import org.projetoverdinho.projetoverdinhoapi.enumerator.StatusAtivo;
//import org.projetoverdinho.projetoverdinhoapi.repository.AnimalRepository;
//import org.projetoverdinho.projetoverdinhoapi.repository.MultaAnimalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Consumer;
//
//@Service
//public class MultaAnimalService implements IService<MultaAnimalModel> {
//
//    @Autowired
//    private MultaAnimalRepository multaAnimalRepository;
//    @Autowired
//    private AnimalRepository animalRepository;
//
//    @Override
//    public MultaAnimalModel add(MultaAnimalModel multa) {
//        return multaAnimalRepository.save(multa);
//    }
//
//    @Override
//    public MultaAnimalModel remove(Long id) {
//        return null;
//    }
//
//    @Override
//    public MultaAnimalModel update(Long id, Map<String, String> updates) {
//        MultaAnimalModel model = getById(id);
//
//        Map<String, Consumer<String>> fieldUpdater = Map.of(
//                "valor", value -> model.setValor(Integer.parseInt(value)),
//                "url_comprovante", value -> model.setUrlComprovante(value),
//                "motivo_cancelamento", value -> model.setMotivoCancelamento(value),
//                "descricao", value -> model.setDescricao(value),
//                "data_multa", value -> model.setDataMulta(LocalDate.parse(value)),
//                "animal_id", value -> {
//                    Long animalId = Long.parseLong(value);
//                    AnimalModel animal = animalRepository.findById(value)
//                            .orElseThrow(() -> new IllegalArgumentException("Animal não encontrado com ID: " + animalId));
//                    model.setAnimal(animal);
//                },
//                "status", value -> model.setStatus(Integer.valueOf(value))
//        );
//
//        updates.forEach((field, value) -> {
//            Consumer<String> updater = fieldUpdater.get(field.toLowerCase());
//            if (updater != null) {
//                updater.accept(value);
//            } else {
//                throw new IllegalArgumentException("Campo inválido para atualização: " + field);
//            }
//        });
//
//        return multaAnimalRepository.save(model);
//    }
//
//    @Override
//    public List<MultaAnimalModel> listAll() {
//        return multaAnimalRepository.findAll();
//    }
//
//    @Override
//    public MultaAnimalModel getById(Long id) {
//        return multaAnimalRepository.findById(id).orElse(null);
//    }
//
//    public MultaAnimalModel addMultaToAnimal(MultaAnimalDTO multaDTO) {
//        AnimalModel animal = animalRepository.findById(multaDTO.animal_id()).orElseThrow(() -> new IllegalArgumentException("Animal não encontrado com ID: " + multaDTO.animalId()));
//
//        MultaAnimalModel multa = new MultaAnimalModel();
//        multa.setDescricao(multaDTO.descricao());
//        multa.setValor(multaDTO.valor());
//        multa.setDataMulta(multaDTO.dataMulta());
//        multa.setStatus(multaDTO.status());
//        multa.setMotivoCancelamento(multaDTO.motivoCancelamento());
//        multa.setUrlComprovante(multaDTO.urlComprovante());
//        multa.setAnimal(animal);
//
//        return multaAnimalRepository.save(multa);
//    }
//}
