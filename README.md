# Command line tool for analyzing text with Lucene/Solr/Elasticsearch

## Usage
```
make build
```

```
java -jar build/libs/lucene-analyzers-1.0-all.jar  "your text 日本"
Script    Bytes                                                       Text
Latin     [79 6f 75 72]                                               your
Latin     [74 65 78 74]                                               text
Jpan      [e6 97 a5 e6 9c ac]                                         日本
```


# Ideas
This lib in alpha version, only one analyzer is supported but this will change soon.
The current supported analyzer is ICUAnalyzer and it can be found in the `package com.jeancsil.cli.analyzers`   

I want to add a new parameter where the user can select the analyzer it wants.


Contact me: me@jeancsil.com