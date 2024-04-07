# WireMock files extension

## Helpers

### `file-content`: include file from "__files" folder

Sample: `GET /person/42` will return content of file `/home/wiremock/__files/person-42.json`

```json
{
  "request": {
    "method": "GET",
    "urlPattern": "/person/\\d+"
  },
  "response": {
    "status": 200,
    "headers": {
      "Content-Type": "application/json"
    },
    "body": "{{#assign 'filename'}}person-{{{request.pathSegments.1}}}.json{{/assign}}  {{file-content filename}}"
  }
}
```

### `file-exists`: tests existence of file in "__files" folder

```json
{
  "response": {
    "body": "{{#assign 'filename'}}person-{{{request.pathSegments.1}}}.json{{/assign}}  {{#if (file-exists filename)}} [...] {{/if}}"
  }
}
```

## Real use case

Build "get multiple" response dynamically from splitted unitary files:

```
[
    {{#each (parseJson request.body) as |id|}}
        {{#assign 'filename'}}subFolder/{{{id}}}.json{{/assign}}

        {{#if (file-exists filename)}}
            {{file-content filename}}
        {{/if}}

        {{#if @last}}{{else}},{{/if}}
    {{/each}}
]
```

## Installation

The extension
is [auto-loaded](https://wiremock.org/docs/extending-wiremock/#extension-registration-via-service-loading): just add JAR
to classpath.

### Sample

```shell
wget https://.../wiremock-files-extension.jar
```

Docker compose:

```yaml
services:
  mocks:
    image: wiremock/wiremock:3x
    volumes:
      - ./wiremock-files-extension.jar:/var/wiremock/extensions/wiremock-files-extension.jar
```
