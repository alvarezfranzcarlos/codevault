Table organizations {
  id UUID [pk]
  name VARCHAR // Ej: 'Empresa Minera S.A.'
  nit VARCHAR [unique] // Ej: '1234567011'
  industry_type VARCHAR // Ej: 'minería'
  status VARCHAR // Ej: 'activo'
}

Table users {
  id UUID [pk]
  organization_id UUID [ref: > organizations.id]
  username VARCHAR // Ej: 'jlopez'
  email VARCHAR [unique] // Ej: 'juan@empresa.com'
  password_hash VARCHAR // Hashed
  role VARCHAR // Ej: 'ADMIN'
  status VARCHAR // Ej: 'activo'
}

Table currencies {
  code VARCHAR(3) [pk] // Ej: 'USD', 'BOB'
  name VARCHAR // Ej: 'Dólar estadounidense'
}

Table branches {
  id UUID [pk]
  country VARCHAR // Ej: 'Bolivia'
  name VARCHAR // Ej: 'BlockFinity Bolivia'
}

Table accounts {
  id UUID [pk]
  organization_id UUID [ref: > organizations.id]
  account_number VARCHAR // Ej: '001-12345678-01'
  currency_code VARCHAR(3) [ref: > currencies.code]
  bank_name VARCHAR // Ej: 'Banco Unión'
  account_type VARCHAR // Ej: 'BANK'
  branch_id UUID [ref: > branches.id]
}

Table wallets {
  id UUID [pk]
  account_id UUID [ref: > accounts.id]
  wallet_address VARCHAR // Ej: '0x1234abcd...'
  platform VARCHAR // Ej: 'KRAKEN'
}

Table orders {
  id UUID [pk]
  type VARCHAR // Ej: 'ON_RAMP'
  status VARCHAR // Ej: 'pendiente'
  user_id UUID [ref: > users.id]
  organization_id UUID [ref: > organizations.id]
  amount NUMERIC(18,6) // Ej: 50000.00
  currency_origin VARCHAR(3) // Ej: 'USD'
  currency_destination VARCHAR(3) // Ej: 'BOB'
  commission_percent NUMERIC(5,2) // Ej: 1.5
  commission_amount NUMERIC(18,6) // Ej: 750.00
  exchange_rate NUMERIC(18,6) // Ej: 6.96
  execution_channel VARCHAR // Ej: 'MANUAL'
  reference_code VARCHAR // Ej: 'TRX1234'
  created_at TIMESTAMP
  updated_at TIMESTAMP
}

Table order_status_log {
  id UUID [pk]
  order_id UUID [ref: > orders.id]
  from_status VARCHAR // Ej: 'pendiente'
  to_status VARCHAR // Ej: 'aprobado'
  reason TEXT // Ej: 'validación manual'
  changed_by_user_id UUID [ref: > users.id]
  timestamp TIMESTAMP
}

Table executions {
  id UUID [pk]
  order_id UUID [ref: > orders.id]
  executed_amount NUMERIC(18,6) // Ej: 49900.00
  executed_at TIMESTAMP
  execution_type VARCHAR // Ej: 'BANK_TRANSFER'
  destination_account VARCHAR // Ej: 'IBAN-12345'
  transaction_reference VARCHAR // Ej: 'SW1234'
  status VARCHAR // Ej: 'SUCCESS'
}
