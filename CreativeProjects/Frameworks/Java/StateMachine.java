public class StateMachine {

    public OrderStatus next(OrderStatus current, OrderEvent trigger) {
        return switch (current) {
            case PENDIENTE -> {
                if (trigger == OrderEvent.REVISAR)
                    yield OrderStatus.EN_REVISION;
                else if (trigger == OrderEvent.CANCELAR)
                    yield OrderStatus.CANCELADA;
                else
                    throw new IllegalStateException("Transición inválida");
            }
            case EN_REVISION -> {
                if (trigger == OrderEvent.EJECUTAR)
                    yield OrderStatus.EJECUTADA;
                else if (trigger == OrderEvent.CANCELAR)
                    yield OrderStatus.CANCELADA;
                else
                    throw new IllegalStateException("Transición inválida");
            }
            case EJECUTADA -> {
                if (trigger == OrderEvent.CONFIRMAR)
                    yield OrderStatus.COMPLETADA;
                else
                    throw new IllegalStateException("Transición inválida");
            }
            default -> throw new IllegalStateException("Estado final alcanzado");
        };
    }
}
