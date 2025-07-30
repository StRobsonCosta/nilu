output "api_url" {
  value = aws_apigatewayv2_api.http_api.api_endpoint
}

output "sns_topic_arn" {
  value = aws_sns_topic.cliente_aviso.arn
}

output "db_endpoint" {
  value = aws_db_instance.postgres.endpoint
}