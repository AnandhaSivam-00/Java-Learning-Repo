# SPR-CL-TRANSACTIONAL

This coding lab covers unit "Spring Data JPA", module "Transaction Management".

## Instructions
- This program is a CRUD application that models cargo ships and containers which the ships can carry. 
- Transactions can be used to group operations together and rollback changes if anything goes wrong (ex: an Exception is thrown)
- Look at Lab.Service.ShipService for any TODO statements.

## Shouldn't Modify (But Look at for Context)
- Exceptions
  - Lab.Exceptions.InvalidTonnageException
  - Lab.Exceptions.NegativeWeightException
- Models
  - Lab.Model.Container
  - Lab.ModelShip
- Repository
  - Lab.Repository.ContainerRepository
  - Lab.Repository.ShipRepository
- Service
  - Lab.Service.ContainerService

## Should Modify
- Lab.Service.ShipService