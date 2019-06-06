

# Selenium-Skeleton

### Maven Arguments

_Browsers_

`-Dbrowser=chrome`

`-Dbrowser=firefox`

`-Dbrowser=edge`

`-Dbrowser=ie`

`-Dbrowser=headless-chrome`

`-Dbrowser=headless-firefox`

_Parallel_

`-Dparallel=both`

_Tags_

`-Dcucumber.options="--tags @google-search"`

_Example Run_

`mvn clean verify -Dbrowser=headless-chrome -Dparallel=both -Dcucumber.options="--tags @google-search"`