# Development

## Required
- **IDE** : Android Studio Giraffe | 2022.3.1
- **JDK** : Java 17을 실행할 수 있는 JDK
- **Kotlin** Language : 1.9.0
- **Min** Sdk : 26
- **Target Sdk** : 33
- **Compile Sdk** : 34

## Language
- **Kotlin**

## Libraries
- **Architecture** : MVI, Clean Architecture
- **Compose** : Navigation
- **Jetpack** : ViewModel
- **DI** : Hilt
- **Asynchronous** : Coroutine
- **Network** : Retrofit2
- **Image** : Glide

  # Architecture
  MVI 패턴을 사용하여 상태를 기반으로 앱이 동작합니다.

  ## Module
  ![조고카페인 모듈 구조](https://github.com/BEEEAM-J/gocafein/assets/107917980/1fc0f37a-343c-40f4-9339-8fdac52bb370)
  
  클린 아키텍처에 따라서 data, domain, presentation 모듈로 구성했습니다.

  ### data
  | data 모듈에는 서버와 통신하기 위한 **api**와 **응답 타입**, **repository의 구현체**가 있습니다. |
  | --- |
  |repository는 domain 모듈에 있지만 클린 아키텍처 의존성 법칙을 지키기 위해서 repository의 구현체를 data 모듈에 위치시켜서 **의존성을 역전**시켰습니다.|
  |data 모듈에는 클린 아키텍처의 **인터페이스 어댑터 역할**과 같이 서버로 부터 받은 데이터를 domain, presentation 모듈에서 편하게 사용하기 위해서 **타입을 변환**하는 기능을 가지고 있습니다.|

  ### domain
  |domain 모듈에는 프로젝트에서 사용할 **model**, **usecase**, **repository**가 있습니다.|
  | --- |
  |domain 계층은 클린 아키텍처의 가장 안쪽에 위치하는 계층으로 어떠한 계층에도 의존하지 않아야 하기 때문에 repository의 구현체를 data 모듈에 위치시켜 **data 모듈을 의존하지 않고 서버로 부터 데이터를 받아올 수 있도록** 하였습니다.|
  
  ### presentation
  |presentation 모듈에는 화면을 보여주는 **composable 함수**들과 **viewModel**이 위치하고 있습니다.|
  | --- |

  # Detail
  |검색 창 Clear 버튼|무한 스크롤|
  | :--: | :--: |
  |![검색창 clear 버튼](https://github.com/BEEEAM-J/gocafein/assets/107917980/bd994c06-48ff-4525-b298-71728b7054d5)|![무한 스크롤](https://github.com/BEEEAM-J/gocafein/assets/107917980/53d5140b-6879-49af-a28b-26f30fdb3e3f)|
  |clear 버튼이 클릭 된 경우 검색 창 상태 값을 빈 값으로 변경하는 방식으로 구현했습니다.|LazyVerticalGrid가 최하단에 닿았을 때 추가 리스트를 요청하는 방식으로 구현했습니다.|

  
