-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 05:16:48
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcontroldeventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `nombre_categoria` varchar(450) NOT NULL,
  `cod_categoria` int(11) NOT NULL,
  `descripcion_categoria` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`nombre_categoria`, `cod_categoria`, `descripcion_categoria`) VALUES
('Perisfericos', 1, 'Dispositivos para PC'),
('Audifonos', 2, 'genericos'),
('cargadores', 3, 'Celular');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `rut_cliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `rut_cliente`) VALUES
(2, '0'),
(3, '10144');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `cod_comp` int(11) NOT NULL,
  `cod_prov` int(11) NOT NULL,
  `numfactura_comp` varchar(10) NOT NULL,
  `fecha_comp` date NOT NULL,
  `total_comp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`cod_comp`, `cod_prov`, `numfactura_comp`, `fecha_comp`, `total_comp`) VALUES
(5, 1, '1', '2021-01-23', 5000),
(6, 1, '1', '2021-01-23', 5000),
(7, 1, '3', '2021-01-23', 25000),
(8, 1, '1', '2021-01-23', 25000),
(9, 1, '1', '2021-01-23', 5000),
(10, 1, '4', '2021-01-24', 5000),
(11, 1, '7', '2021-01-24', 5000),
(12, 1, '98', '2021-01-24', 24000),
(13, 1, '1217', '2021-02-26', 50000),
(14, 2, '1458', '2021-06-16', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `cod_deta_comp` int(11) NOT NULL,
  `cod_comp` int(11) NOT NULL,
  `cod_productoFK` bigint(20) NOT NULL,
  `bodega_deta_comp` varchar(10) DEFAULT NULL,
  `catidad_deta_comp` int(11) NOT NULL,
  `preciouni_deta_comp` int(20) NOT NULL,
  `preciototal_deta_comp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_compra`
--

INSERT INTO `detalle_compra` (`cod_deta_comp`, `cod_comp`, `cod_productoFK`, `bodega_deta_comp`, `catidad_deta_comp`, `preciouni_deta_comp`, `preciototal_deta_comp`) VALUES
(5, 5, 3, '1', 1, 5000, 5000),
(6, 6, 3, 'b1', 1, 5000, 5000),
(7, 7, 3, 'a1', 5, 5000, 25000),
(8, 8, 3, '1', 5, 5000, 25000),
(9, 9, 3, 'a1', 1, 5000, 5000),
(10, 10, 3, 'a2', 1, 5000, 5000),
(11, 11, 3, 'a3', 1, 5000, 5000),
(12, 12, 3, 'a4', 4, 6000, 24000),
(13, 13, 6, '1', 10, 5000, 50000),
(14, 14, 6, 'd2', 1, 5000, 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `cod_detalle` int(11) NOT NULL,
  `cantidad_detalle` int(11) NOT NULL,
  `cod_productoFK` bigint(20) NOT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `cod_ventaFK` int(11) NOT NULL,
  `subtotal` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`cod_detalle`, `cantidad_detalle`, `cod_productoFK`, `precio_producto`, `cod_ventaFK`, `subtotal`) VALUES
(1, 1, 3, 12000, 6, 12000),
(2, 1, 3, 12000, 7, 12000),
(4, 5, 6, 10000, 11, 50000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devoluciones`
--

CREATE TABLE `devoluciones` (
  `cod_detalle` int(11) NOT NULL,
  `cantidad_detalle` int(11) NOT NULL,
  `cod_productoFK` bigint(11) NOT NULL,
  `precio_producto` int(11) NOT NULL,
  `cod_venta` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `subprecioCompra` int(11) NOT NULL,
  `precio_compra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `garantias`
--

CREATE TABLE `garantias` (
  `cod_garantia` bigint(20) NOT NULL,
  `cod_producto` int(11) NOT NULL,
  `detalle_garantia` varchar(200) DEFAULT NULL,
  `precio_compra` bigint(20) NOT NULL,
  `cod_provedor` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `cod_historial` int(11) NOT NULL,
  `cod_productoFK1` bigint(20) NOT NULL,
  `cod_usuarioFK1` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `referencia` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `cod_persona` int(11) NOT NULL,
  `nombre_persona` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `cel_contacto` varchar(10) DEFAULT NULL,
  `correo_contacto` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cod_persona`, `nombre_persona`, `direccion`, `telefono`, `email`, `contacto`, `cel_contacto`, `correo_contacto`) VALUES
(1, 'victor', 'cll 8 no 5 12 ', '32158506457', 'visteblanco@gmail.com', NULL, NULL, NULL),
(2, 'Cliente General', '0', '0', '0', NULL, NULL, NULL),
(3, 'Andrey', 'Restrepo', '320', '', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_unitario`
--

CREATE TABLE `precio_unitario` (
  `cod_prec` int(11) NOT NULL,
  `cod_productoFK` bigint(11) NOT NULL,
  `preciouni_prec` int(11) NOT NULL,
  `costototal_prec` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `descripcion_producto` varchar(255) DEFAULT NULL,
  `unidad_producto` varchar(20) NOT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `stock_producto` int(11) NOT NULL,
  `ubicacion_bodega` varchar(250) DEFAULT NULL,
  `cod_categoriaFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_producto`, `nombre_producto`, `descripcion_producto`, `unidad_producto`, `precio_producto`, `stock_producto`, `ubicacion_bodega`, `cod_categoriaFK`) VALUES
(3, 'a', 'a', 'Unidad', 12000, 17, NULL, 2),
(6, 'carg sam', 'sam', 'Unidad', 10000, 6, 'd2', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoescaneado`
--

CREATE TABLE `productoescaneado` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre` varchar(450) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productostock`
--

CREATE TABLE `productostock` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre_producto` varchar(450) NOT NULL,
  `descripcion_producto` varchar(450) DEFAULT NULL,
  `unidad_producto` varchar(450) DEFAULT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `precio_compra` bigint(20) NOT NULL,
  `stock_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cod_prov` int(11) NOT NULL,
  `nombre_prov` varchar(50) NOT NULL,
  `direccion_prov` varchar(60) NOT NULL,
  `telefono_prov` varchar(20) NOT NULL,
  `nit_prov` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cod_prov`, `nombre_prov`, `direccion_prov`, `telefono_prov`, `nit_prov`) VALUES
(1, 'tecnoshop', 'Villacicencio', '3008175650', '000000000-0'),
(2, 'lexa', 'v/cio', '300', '90058');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cod_usuario` int(11) NOT NULL,
  `rut_usuario` varchar(20) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `acceso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cod_usuario`, `rut_usuario`, `login`, `password`, `estado`, `acceso`) VALUES
(1, '1018440096', '12345', '12345', 'Activo', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `cod_venta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `total_venta` bigint(20) NOT NULL,
  `cod_usuarioFK` int(11) NOT NULL,
  `cod_clienteFK` int(11) NOT NULL,
  `tipo_comprobante` varchar(10) NOT NULL,
  `num_factura` bigint(20) DEFAULT NULL,
  `pago` bigint(20) NOT NULL,
  `descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`cod_venta`, `fecha_venta`, `total_venta`, `cod_usuarioFK`, `cod_clienteFK`, `tipo_comprobante`, `num_factura`, `pago`, `descuento`) VALUES
(2, '2021-02-04', 0, 1, 2, 'Boleta', 0, 0, 0),
(3, '2021-02-04', 0, 1, 2, 'Boleta', 0, 0, 0),
(4, '2021-02-04', 0, 1, 2, 'Boleta', 0, 0, 0),
(5, '2021-02-04', 0, 1, 2, 'Boleta', 0, 0, 0),
(6, '2021-02-04', 12000, 1, 2, 'Boleta', 0, 0, 0),
(7, '2021-02-04', 12000, 1, 2, 'Boleta', 0, 0, 0),
(10, '2021-02-04', 0, 1, 2, 'Boleta', 0, 0, 0),
(11, '2021-02-26', 50000, 1, 2, 'Boleta', 0, 50000, 0),
(12, '2021-06-16', 0, 1, 3, 'Boleta', 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`cod_comp`),
  ADD KEY `prov_comp` (`cod_prov`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`cod_deta_comp`),
  ADD KEY `comp_deta_comp` (`cod_comp`),
  ADD KEY `prod_deta_comp` (`cod_productoFK`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`cod_detalle`,`cod_ventaFK`),
  ADD KEY `detalle_productoFK_idx` (`cod_productoFK`),
  ADD KEY `detalle_ventaFK_idx` (`cod_ventaFK`);

--
-- Indices de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD PRIMARY KEY (`cod_detalle`),
  ADD KEY `devolucion_ventas` (`cod_venta`),
  ADD KEY `Pro_dev` (`cod_productoFK`);

--
-- Indices de la tabla `garantias`
--
ALTER TABLE `garantias`
  ADD PRIMARY KEY (`cod_garantia`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`cod_historial`),
  ADD KEY `historial_productoFK_idx` (`cod_productoFK1`),
  ADD KEY `historial_usuarioFK_idx` (`cod_usuarioFK1`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`cod_persona`);

--
-- Indices de la tabla `precio_unitario`
--
ALTER TABLE `precio_unitario`
  ADD PRIMARY KEY (`cod_prec`),
  ADD KEY `cod_productoFK` (`cod_productoFK`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`cod_producto`,`cod_categoriaFK`),
  ADD KEY `cod_cat_prodFK_idx` (`cod_categoriaFK`);

--
-- Indices de la tabla `productoescaneado`
--
ALTER TABLE `productoescaneado`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `productostock`
--
ALTER TABLE `productostock`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`cod_prov`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`cod_venta`),
  ADD KEY `venta_usuarioFK_idx` (`cod_usuarioFK`),
  ADD KEY `venta_clienteFK_idx` (`cod_clienteFK`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `cod_comp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  MODIFY `cod_deta_comp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `cod_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  MODIFY `cod_detalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `garantias`
--
ALTER TABLE `garantias`
  MODIFY `cod_garantia` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `cod_historial` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `cod_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `precio_unitario`
--
ALTER TABLE `precio_unitario`
  MODIFY `cod_prec` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `cod_prov` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `cod_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_personaFK` FOREIGN KEY (`cod_cliente`) REFERENCES `persona` (`cod_persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `prov_comp` FOREIGN KEY (`cod_prov`) REFERENCES `proveedores` (`cod_prov`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `comp_deta_comp` FOREIGN KEY (`cod_comp`) REFERENCES `compras` (`cod_comp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `prod_deta_comp` FOREIGN KEY (`cod_productoFK`) REFERENCES `producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_productoFK` FOREIGN KEY (`cod_productoFK`) REFERENCES `producto` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_ventaFK` FOREIGN KEY (`cod_ventaFK`) REFERENCES `venta` (`cod_venta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD CONSTRAINT `Pro_dev` FOREIGN KEY (`cod_productoFK`) REFERENCES `producto` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `devolucion_ventas` FOREIGN KEY (`cod_venta`) REFERENCES `venta` (`cod_venta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `cod_productoFK1` FOREIGN KEY (`cod_productoFK1`) REFERENCES `producto` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cod_usuarioFK1` FOREIGN KEY (`cod_usuarioFK1`) REFERENCES `usuario` (`cod_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `precio_unitario`
--
ALTER TABLE `precio_unitario`
  ADD CONSTRAINT `precio_unitario_ibfk_1` FOREIGN KEY (`cod_productoFK`) REFERENCES `producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `cod_cat_prodFK` FOREIGN KEY (`cod_categoriaFK`) REFERENCES `categoria` (`cod_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_personaFK` FOREIGN KEY (`cod_usuario`) REFERENCES `persona` (`cod_persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_clienteFK` FOREIGN KEY (`cod_clienteFK`) REFERENCES `cliente` (`cod_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `venta_usuarioFK` FOREIGN KEY (`cod_usuarioFK`) REFERENCES `usuario` (`cod_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
