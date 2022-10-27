# Instalação openjdk ubuntu

Passo a passo para instalação do openjdk-11.

1. Verificando se o jdk está instalado na máquina

```console
java -version
```
2. Comando para instalação do opendjk-11.
```console
sudo apt-get install openjdk-11-jdk
```
3. Confirmação se o jdk foi instaldo.
```console
java -version
```

4. Configuração do ambiente JAVA_HOME.

4.1 Verificar caminho de instalação do Java:
```console 
sudo update-alternatives --config java
```  

4.2 Copiar o caminho de instalação
4.3 Editar o arquivo .bashrc adicionado o comando abaixo.
```console
JAVA_HOME=colar caminho de instalação do java com exceção do /bin/java
export JAVA_HOME
export PATH=$PATH:$JAVA_HOME
```
4.4 Salvar arquivo

4.4 Verificar se alteração foi salva.
```console
cat ~/.bashrc
```
5. Feche o terminal e abra novamente.
6. Verifique mais uma vez se o java está instalado
```console
java -version
```

# IDE Intellij 

**1.** Entrar no site intellij

**2.** Escolher a versão comunity para ubuntu.

**3.** Descompactar a pasta e abrir o terminal.

**4.** Entrar na pasta descompactada.

```console
cd Downloads/IdealC
```

**6.** Executar o arquivo de instalação

```console
./idea.sh
```