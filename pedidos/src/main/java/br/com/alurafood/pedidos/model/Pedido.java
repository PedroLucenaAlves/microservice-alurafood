package br.com.alurafood.pedidos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull @Enumerated(EnumType.STRING)
    private Status status;

    //Representa um relacionamento One-to-Many (um-para-muitos) entre a entidade Pedidos e a entidade ItemDoPedido (um pedido pode ter vários itens)

    //cascade=CascadeType.PERSIST
    //ao salvar um pedido, os itens associados a esse pedido também são salvos sem a necessidade de explicitamente chamar o método save no repositório de ItemDoPedido.


    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="pedido")
    private List<ItemDoPedido> itens = new ArrayList<>();
}
