package com.example.demo;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Component;

/**
 * Wrapper over the Actuator's health endpoint. It gets an instance of it via injection and invokes
 * it directly on invoke. This is used to produce the same results that were available on /health on
 * the /live endpoint as required by the PENG platform.
 */
@Component
@Endpoint(id = "ready")
public class ReadyEndpoint {

  HealthEndpoint delegate;

  public ReadyEndpoint(HealthEndpoint delegate){
    this.delegate = delegate;
  }

  @ReadOperation
  public HealthComponent ready() {
    return delegate.health();
  }
}
