# provider "aws" {
#   region = "us-east-1"
# }
#
# module "vpc" {
#   source = "terraform-aws-modules/vpc/aws"
#   name   = "ateliê-vpc"
#   cidr   = "10.0.0.0/16"
#   azs    = ["us-east-1a"]
# }
#
# module "db" {
#   source  = "terraform-aws-modules/rds/aws"
#   engine  = "postgres"
# }
#
# resource "aws_sns_topic" "cliente_aviso" {
#   name = "AvisosClientes"
# }
#
# resource "aws_lambda_function" "api_lambda" {
#   filename         = "target/esteira-costura-1.0.0.jar"
#   function_name    = "EsteiraCosturaFunction"
#   runtime          = "java17"
#   handler          = "org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"
#   # role             = aws_iam_role.lambda_exec.arn
# }