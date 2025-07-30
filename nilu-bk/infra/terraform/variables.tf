variable "region" {
  default = "us-east-1"
}

variable "project_name" {
  default = "esteira-costura"
}

variable "db_username" {
  default = "admin"
}

variable "db_password" {
  description = "Senha do banco de dados"
  sensitive   = true
}