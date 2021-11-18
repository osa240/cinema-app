package serhii.orlov.spring.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import serhii.orlov.spring.dto.response.ShoppingCartResponseDto;
import serhii.orlov.spring.model.ShoppingCart;
import serhii.orlov.spring.model.Ticket;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
