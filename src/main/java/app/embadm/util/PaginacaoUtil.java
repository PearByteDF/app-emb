package app.embadm.util;

import app.embadm.entity.PessoaEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaginacaoUtil {

    public static Page<?> criar(Pageable pageable, List<?> listaDeDados) {
        return new PageImpl(
                validarTamanhoDaLista(listaDeDados.size(), pageable.getPageSize() * pageable.getPageNumber())
                        ? Collections.emptyList() : listaDeDados.subList(pageable.getPageSize() * pageable.getPageNumber(),
                        Math.min((pageable.getPageNumber() * pageable.getPageSize()) + pageable.getPageSize(),
                                listaDeDados.size())),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), listaDeDados.size());
    }

    public static List<Integer> gerarTotalDePaginas (Integer totalDePaginas) {
        return totalDePaginas > 0 ? IntStream.rangeClosed(1, totalDePaginas).boxed()
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    private static boolean validarTamanhoDaLista(Integer totalDeDados, Integer paginaInicial) {
        return totalDeDados < paginaInicial;
    }
}
