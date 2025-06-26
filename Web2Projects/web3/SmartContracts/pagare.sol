// SPDX-License-Identifier: MIT
pragma solidity ^0.8.17;

/// @title Pagare Digital - Contrato que representa un pagaré verificable en blockchain
contract PagareDigital {

    /// @dev Representa una estructura de pagaré individual
    struct Pagare {
        uint256 id;                 // Identificador único del pagaré
        address emisor;            // Dirección del creador del pagaré
        address beneficiario;      // A quién se le debe pagar
        uint256 monto;             // Valor asociado al pagaré (en wei)
        uint256 fechaVencimiento;  // Fecha en que se puede ejecutar el pago (timestamp)
        bool pagado;               // Estado de pago
        bytes32 hashDocumento;     // Hash del documento o contrato legal (simula firma digital)
    }

    /// @dev Contador para generar identificadores únicos
    uint256 public contadorPagare;

    /// @dev Registro público de todos los pagarés creados
    mapping(uint256 => Pagare) public pagares;

    /// @dev Evento emitido cuando se crea un nuevo pagaré
    event PagareCreado(uint256 indexed id, address indexed emisor, address indexed beneficiario);

    /// @dev Evento emitido cuando se marca un pagaré como pagado
    event PagarePagado(uint256 indexed id);

    /// @notice Crea un nuevo pagaré digital
    /// @param _beneficiario Dirección que recibirá el pago
    /// @param _monto Monto a pagar (en wei)
    /// @param _fechaVencimiento Timestamp después del cual se puede ejecutar el pago
    /// @param _hashDocumento Hash SHA256 del documento firmado (simula evidencia criptográfica)
    function crearPagare(
        address _beneficiario,
        uint256 _monto,
        uint256 _fechaVencimiento,
        bytes32 _hashDocumento
    ) external {
        require(_beneficiario != address(0), "Beneficiario invalido");
        require(_monto > 0, "Monto debe ser mayor a cero");
        require(_fechaVencimiento > block.timestamp, "Fecha vencimiento debe ser futura");

        pagares[contadorPagare] = Pagare({
            id: contadorPagare,
            emisor: msg.sender,
            beneficiario: _beneficiario,
            monto: _monto,
            fechaVencimiento: _fechaVencimiento,
            pagado: false,
            hashDocumento: _hashDocumento
        });

        emit PagareCreado(contadorPagare, msg.sender, _beneficiario);
        contadorPagare++;
    }

    /// @notice Marca el pagaré como pagado (simulación de ejecución)
    /// Solo puede ser ejecutado por el beneficiario, después de la fecha de vencimiento
    function ejecutarPago(uint256 _id) external {
        Pagare storage p = pagares[_id];
        require(msg.sender == p.beneficiario, "No autorizado");
        require(!p.pagado, "Ya pagado");
        require(block.timestamp >= p.fechaVencimiento, "No ha vencido");

        // Simulación: en la práctica deberías integrar un token o transferencia real
        p.pagado = true;
        emit PagarePagado(_id);
    }

    /// @notice Consulta si un pagaré es válido y aún no pagado
    function esPagareActivo(uint256 _id) external view returns (bool) {
        Pagare memory p = pagares[_id];
        return (!p.pagado && block.timestamp < p.fechaVencimiento);
    }
}
