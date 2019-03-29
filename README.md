
```bash
❯ sbt '; clean; compile'
[info] Compiling 2 Scala sources to */target/scala-2.12/classes ...
[warn] an unexpected type representation reached the compiler backend while compiling KorolevScalaBug.scala: <notype>. If possible, please file a bug on https://github.com/scala/bug/issues.
[error] Error while emitting KorolevScalaBug.scala
[error] <notype> (of class scala.reflect.internal.Types$NoType$)
[warn] one warning found
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 9 s, completed 29 мар. 2019 г., 14:08:58
```